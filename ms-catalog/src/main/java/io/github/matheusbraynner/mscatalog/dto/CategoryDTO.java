package io.github.matheusbraynner.mscatalog.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.matheusbraynner.mscatalog.entities.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategoryDTO {

    private String name;

    private Boolean active;

    private List<Category> childrenCategory;
}
