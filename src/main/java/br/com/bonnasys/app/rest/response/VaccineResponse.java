package br.com.bonnasys.app.rest.response;

import java.time.OffsetDateTime;

public record VaccineResponse(String id,
                              String name,
                              String producer,
                              OffsetDateTime createdAt,
                              OffsetDateTime updatedAt) {}
