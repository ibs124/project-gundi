package ibs124.gundi.model.api;

public record RegisterBindingModel(
        String email,
        String password,
        String fullName,
        String username) {
}