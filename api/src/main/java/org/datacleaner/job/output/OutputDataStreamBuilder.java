/**
 * DataCleaner (community edition)
 * Copyright (C) 2014 Free Software Foundation, Inc.
 *
 * This copyrighted material is made available to anyone wishing to use, modify,
 * copy, or redistribute it subject to the terms and conditions of the GNU
 * Lesser General Public License, as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License
 * for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this distribution; if not, write to:
 * Free Software Foundation, Inc.
 * 51 Franklin Street, Fifth Floor
 * Boston, MA  02110-1301  USA
 */
package org.datacleaner.job.output;

import org.apache.metamodel.schema.Column;
import org.apache.metamodel.schema.ColumnType;
import org.apache.metamodel.schema.Table;
import org.datacleaner.api.InputColumn;
import org.datacleaner.api.OutputDataStream;

/**
 * Builder object for easily creating {@link OutputDataStream} objects.
 * 用于轻松创建{@link OutputDataStream}对象的Builder对象。
 */
public interface OutputDataStreamBuilder {

    OutputDataStream toOutputDataStream();

    OutputDataStreamBuilder likeTable(Table table);

    OutputDataStreamBuilder withColumn(String name, ColumnType columnType);

    OutputDataStreamBuilder withColumnLike(InputColumn<?> column);

    OutputDataStreamBuilder withColumnLike(Column column);
}
