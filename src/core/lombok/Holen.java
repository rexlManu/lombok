package core.lombok;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Put on any field to make lombok build a standard getter.
 * <p>
 * Complete documentation is found at <a href="https://projectlombok.org/features/GetterSetter">the project lombok features page for &#64;Getter and &#64;Setter</a>.
 * <p>
 * Even though it is not listed, this annotation also has the {@code onMethod} parameter. See the full documentation for more details.
 * <p>
 * Example:
 * <pre>
 *     private &#64;Getter int foo;
 * </pre>
 *
 * will generate:
 *
 * <pre>
 *     public int getFoo() {
 *         return this.foo;
 *     }
 * </pre>
 * <p>
 * This annotation can also be applied to a class, in which case it'll be as if all non-static fields that don't already have
 * a {@code @Getter} annotation have the annotation.
 */
@Target({ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.SOURCE)
public @interface Holen {
    /**
     * If you want your getter to be non-public, you can specify an alternate access level here.
     *
     * @return The getter method will be generated with this access modifier.
     */
    lombok.AccessLevel value() default lombok.AccessLevel.PUBLIC;

    /**
     * Any annotations listed here are put on the generated method.
     * The syntax for this feature depends on JDK version (nothing we can do about that; it's to work around javac bugs).<br>
     * up to JDK7:<br>
     *  {@code @Getter(onMethod=@__({@AnnotationsGoHere}))}<br>
     * from JDK8:<br>
     *  {@code @Getter(onMethod_={@AnnotationsGohere})} // note the underscore after {@code onMethod}.
     *
     * @return List of annotations to apply to the generated getter method.
     */
    lombok.Getter.AnyAnnotation[] onMethod() default {};

    boolean lazy() default false;

    /**
     * Placeholder annotation to enable the placement of annotations on the generated code.
     * @deprecated Don't use this annotation, ever - Read the documentation.
     */
    @Deprecated
    @Retention(RetentionPolicy.SOURCE)
    @Target({})
    @interface AnyAnnotation {}
}
