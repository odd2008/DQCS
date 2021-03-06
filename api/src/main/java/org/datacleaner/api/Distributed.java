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
package org.datacleaner.api;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation used to override the default component distribution and clustering
 * model. Any component (transformer, filter or analyzer) with this annotation
 * can define whether or not it can be distributed in a server cluster or not. A
 * distributed component will have multiple instances, all with the same
 * configuration. But since there are more instances, naturally they need to be
 * either stateless or have a state-logic which supports separate execution.
 * 用于覆盖默认组件分布和聚类模型的注释。
 * 具有此注释的任何组件（转换器，过滤器或分析器）都可以定义它是否可以分布在服务器群集中。
 * 分布式组件将具有多个实例，所有实例都具有相同的配置。
 * 但是由于存在更多的实例，因此它们自然需要是无状态的或具有支持单独执行的状态逻辑。
 *
 * The default behaviour of the components is:
 *
 * <ul>
 * <li>Transformers and Filters are by default distributed. The rationale behind
 * this default value is that the invoked methods (transform(...) and
 * categorize(...)) both return their results immidiately and thus a stateless
 * implementation will be the normal scenario.</li>
 * <li>Analyzers are by default <i>not</i> distributed. The rationale behind
 * this default value is that analyzers are expected to build up it's result
 * during execution and thus will typically be stateful. If a Analyzer is to be
 * distributed, it needs, or it's {@link AnalyzerResult} class needs, to specify
 * a {@link AnalyzerResultReducer} value for the {@link #reducer()} field.</li>
 * </ul>
 * 组件的默认行为是：
 *   默认情况下，转换器和过滤器是分布式的。
 * 这个默认值的基本原理是被调用的方法（transform（...）和categorize（...））都立即返回其结果，
 * 因此无状态实现将是正常情况。
 *   默认情况下，分析器不分发。此默认值的基本原理是，分析人员应在执行过程中构建其结果，
 * 因此通常是有状态的。如果要分发分析器，
 * 则需要或它的{@link AnalyzerResult}类需要为{@link #reducer（）}字段指定一个{@link AnalyzerResultReducer}值。
 *
 * @see Filter
 * @see Transformer
 * @see Analyzer
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
@Documented
public @interface Distributed {

    /**
     * Determines whether or not the component with this annotation is
     * distributable.
     *
     * @return a boolean indicating whether or not distributed execution of the
     *         component is allowed.
     */
    boolean value() default true;

    /**
     * Gets a reducer class for {@link AnalyzerResult}s generated by this
     * component (applies to Analyzer or AnalyzerResult classes only).
     *
     * @return a reducer class for results generated by this component.
     */
    Class<? extends AnalyzerResultReducer<?>> reducer() default NoAnalyzerResultReducer.class;
}
