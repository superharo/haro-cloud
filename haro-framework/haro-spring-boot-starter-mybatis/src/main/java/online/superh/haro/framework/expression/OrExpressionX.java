package online.superh.haro.framework.expression;

import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.operators.conditional.OrExpression;

/**
 * @version: 1.0
 * @author: haro
 * @description:
 *
 *  OrExpression 的扩展类(会在原有表达式两端加上括号)
 *
 * @date: 2023-09-07 10:11
 */
public class OrExpressionX extends OrExpression {

    public OrExpressionX() {
    }

    public OrExpressionX(Expression leftExpression, Expression rightExpression) {
        this.setLeftExpression(leftExpression);
        this.setRightExpression(rightExpression);
    }

    @Override
    public String toString() {
        return "(" + super.toString() + ")";
    }

}
