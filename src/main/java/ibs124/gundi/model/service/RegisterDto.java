package ibs124.gundi.model.service;

public record RegisterDto(
        String email,
        String password,
        String fullName,
        String username) {
}