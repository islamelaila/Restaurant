package com.spring.boot.helper;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MessageResponse {
    private String Message ;

    private String message_ar;

    private String message_en;

    private String message_fr;

    public MessageResponse(String message) {
        Message = message;
    }

    public MessageResponse(String message_ar, String message_en, String message_fr) {
        this.message_ar = message_ar;
        this.message_en = message_en;
        this.message_fr = message_fr;
    }
}
