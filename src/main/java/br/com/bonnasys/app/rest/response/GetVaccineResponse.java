package br.com.bonnasys.app.rest.response;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.time.OffsetDateTime;
import java.util.UUID;

public record GetVaccineResponse(
        UUID id,
        @Schema(example = "HPV")
        String name,
        @Schema(example = "Janssen")
        String producer,
        OffsetDateTime createdAt,
        OffsetDateTime updatedAt
) {
}
