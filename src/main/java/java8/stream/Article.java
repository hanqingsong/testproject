package java8.stream;

import lombok.*;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor
public class Article {
    private Boolean ad;
    private Integer subtype;
    private Integer joinNum;
    private Integer createTime;
}