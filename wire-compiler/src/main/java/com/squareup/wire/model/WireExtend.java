/*
 * Copyright (C) 2015 Square, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.squareup.wire.model;

import com.google.common.collect.ImmutableList;
import com.squareup.protoparser.ExtendElement;
import com.squareup.protoparser.FieldElement;

public final class WireExtend {
  private final String packageName;
  private final ExtendElement element;
  private final ImmutableList<WireField> fields;
  private ProtoTypeName protoTypeName;

  WireExtend(String packageName, ExtendElement element) {
    this.packageName = packageName;
    this.element = element;

    ImmutableList.Builder<WireField> fields = ImmutableList.builder();
    for (FieldElement field : element.fields()) {
      fields.add(new WireField(packageName, field));
    }
    this.fields = fields.build();
  }

  public String packageName() {
    return packageName;
  }

  public ProtoTypeName protoTypeName() {
    return protoTypeName;
  }

  public String documentation() {
    return element.documentation();
  }

  public ImmutableList<WireField> fields() {
    return fields;
  }

  void link(Linker linker) {
    for (WireField field : fields) {
      field.link(linker);
    }
    protoTypeName = linker.resolveNamedType(packageName, element.name());
  }
}