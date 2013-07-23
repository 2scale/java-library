package com.urbanairship.api.common.parse;

import com.google.common.base.Optional;

public interface FieldParserRegistry<T, R extends JsonObjectReader<T>> {

    Optional<FieldParser<R>> getFieldParser(String fieldName);

}