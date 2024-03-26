package com.ingress.autosales.specification;

import com.ingress.autosales.criteria.SearchCriteria;
import com.ingress.autosales.domain.AutoEntity;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;

public class AutoSpecification implements Specification<AutoEntity> {

    private SearchCriteria criteria;//TODO: search if the best practice is Singleton or not for this Object

    public AutoSpecification(SearchCriteria criteria) {
        this.criteria = criteria;
    }

    @Override
    public Predicate toPredicate(Root<AutoEntity> root, CriteriaQuery<?> query, CriteriaBuilder builder) {

        Path<?> path = getPath(root, criteria.getKey());

        if (criteria.getOperation().equalsIgnoreCase(":")) {
            if (path.getJavaType() == String.class) {
                return builder.like((Path<String>) path, "%" + criteria.getValue() + "%");
            } else {
                return builder.equal(path, criteria.getValue());
            }
        } else if (criteria.getOperation().equalsIgnoreCase(">") || criteria.getOperation().equalsIgnoreCase("<")) {
            if (path.getJavaType() == Integer.class) {
                Path<Integer> integerPath = (Path<Integer>) path;
                Integer value = Integer.parseInt(criteria.getValue().toString());
                return criteria.getOperation().equalsIgnoreCase(">") ?
                        builder.greaterThanOrEqualTo(integerPath, value) :
                        builder.lessThanOrEqualTo(integerPath, value);
            } else if (path.getJavaType() == BigDecimal.class) {
                Path<BigDecimal> bigDecimalPath = (Path<BigDecimal>) path;
                BigDecimal value = new BigDecimal(criteria.getValue().toString());
                return criteria.getOperation().equalsIgnoreCase(">") ?
                        builder.greaterThanOrEqualTo(bigDecimalPath, value) :
                        builder.lessThanOrEqualTo(bigDecimalPath, value);
            }
        }

        return null;
    }

    private Path<?> getPath(Root<AutoEntity> root, String key) {
        Path<?> path = root;
        if (key.contains(".")) {
            for (String part : key.split("\\.")) {
                path = path.get(part);
            }
        } else {
            path = root.get(key);
        }
        return path;
    }

}

