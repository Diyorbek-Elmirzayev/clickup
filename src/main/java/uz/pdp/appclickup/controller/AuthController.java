package uz.pdp.appclickup.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.appclickup.payload.ApiResponse;
import uz.pdp.appclickup.payload.LoginDTO;
import uz.pdp.appclickup.payload.RegisterDTO;
import uz.pdp.appclickup.service.AuthService;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    HttpEntity<?> register(@RequestBody @Valid RegisterDTO registerDTO) {
        ApiResponse apiResponse = authService.registerUser(registerDTO);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }

    @PostMapping("/login")
    HttpEntity<?> login(@RequestBody @Valid LoginDTO loginDTO) {
        try {
            ApiResponse apiResponse = authService.login(loginDTO);
            return ResponseEntity.ok(apiResponse);
        } catch (Exception e) {
            return ResponseEntity.ok(new ApiResponse("Parol yoki login xato", false));
        }
    }

    @PostMapping("/verifyEmail")
    HttpEntity<?> register(@RequestParam String email,@RequestParam String emailCode) {
        ApiResponse apiResponse = authService.verifyEmail(email,emailCode);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }
}
