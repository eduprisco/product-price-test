package com.inditex.test.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

/**
 * Class that represents an api error.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "error_response")
public class ErrorResponse extends Object{

    @Schema(description = "The message of error occurred.", example = "An error has occurred and this is its description.")
    @JsonProperty("rmessage")
    private String message;

    @Schema(description = "The internal request identifier.", example = "Swekcv45abgj6")
    @JsonProperty("request_id")
    private String requestId;
}
