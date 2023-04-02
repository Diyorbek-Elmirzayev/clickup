package uz.pdp.appclickup.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.pdp.appclickup.entity.User;
import uz.pdp.appclickup.entity.enums.SystemRoleName;
import uz.pdp.appclickup.payload.ApiResponse;
import uz.pdp.appclickup.payload.LoginDTO;
import uz.pdp.appclickup.payload.RegisterDTO;
import uz.pdp.appclickup.repository.UserRepository;
import uz.pdp.appclickup.security.JwtProvider;

import java.util.Optional;
import java.util.Random;

@Service

public class AuthService implements UserDetailsService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JavaMailSender javaMailSender;
    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;
    @Value("${spring.mail.username}")
    private String sender;

    public AuthService(UserRepository userRepository,
                       @Lazy PasswordEncoder passwordEncoder,
                       JavaMailSender javaMailSender,
                       @Lazy AuthenticationManager authenticationManager,
                       JwtProvider jwtProvider) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.javaMailSender = javaMailSender;
        this.authenticationManager = authenticationManager;
        this.jwtProvider = jwtProvider;
    }


    public ApiResponse registerUser(RegisterDTO registerDTO) {
        boolean existsByEmail = userRepository.existsByEmail(registerDTO.getEmail());
        if (existsByEmail) {
            return new ApiResponse("User allaqachon mavjud", false);
        }

        User user = new User(
                registerDTO.getFullName(),
                registerDTO.getEmail(),
                passwordEncoder.encode(registerDTO.getPassword()),
                SystemRoleName.SYSTEM_USER
        );

        int code = new Random().nextInt(999999);
        user.setEmailCode(String.valueOf(code));
        userRepository.save(user);
        sendEmail(user.getEmail(), user.getEmailCode());
        return new ApiResponse("User muvaffaqiyatli saqlandi", true);
    }

    public void sendEmail(String sendingEmail, String emailCode) {
        SimpleMailMessage mailMessage
                = new SimpleMailMessage();
        mailMessage.setFrom(sender);
        mailMessage.setTo(sendingEmail);
        mailMessage.setSubject("Accountni tasdiqlang");
        mailMessage.setText("CLICK_LINK: " + "http://localhost:8080/api/auth/verifyEmail?emailCode=" + emailCode + "&email=" + sendingEmail);

        javaMailSender.send(mailMessage);
    }

    public ApiResponse login(LoginDTO loginDTO) {
        Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDTO.getEmail(),
                        loginDTO.getPassword()
                )
        );
        User user = (User) authenticate.getPrincipal();
        String token = jwtProvider.generateToken(user.getEmail());
        return new ApiResponse("Successfully signed", true, token);

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username).orElseThrow(() ->
                new UsernameNotFoundException(username + " topilmadi"));
    }

    public ApiResponse verifyEmail(String email, String emailCode) {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if (optionalUser.isEmpty()) return new ApiResponse("User not found", false);
        User user = optionalUser.get();
        if (emailCode.equals(user.getEmailCode())) {
            user.setEnabled(true);
            user.setEmailCode(null);
            userRepository.save(user);
            return new ApiResponse("Account tasdiqlandi", true);
        }
        return new ApiResponse("Kod xato", false);
    }
}
