package io.github.MKAbuMattar.isomessaging.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuoteModel {
    private String content;
    private String author;
}
