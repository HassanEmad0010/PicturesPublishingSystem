package com.hassanemad.picturespublishing.dto;


import jakarta.validation.constraints.NotBlank;

public record AdminDto(@NotBlank String userName, boolean isLoggedIn) {



}