package domain;


import lombok.*;


// @Getter, @Setter, @NonNull, @EqualsAndHashCode, @ToString 에 대한 걸 모두 해주는 Annotation
@Data
public class Product {

    int id;
    String name;
    float price;
    String countryCode;

}
