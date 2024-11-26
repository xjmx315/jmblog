package com.gdgstudy.jmblog.Comment;

import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaAttributeConverter<Comment, Long> {
}
