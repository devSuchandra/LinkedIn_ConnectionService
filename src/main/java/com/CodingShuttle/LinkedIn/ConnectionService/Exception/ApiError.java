package com.CodingShuttle.LinkedIn.ConnectionService.Exception;

public record ApiError(int status, String error, String message) {
}
