package cn.edu.thu.tsfile.timeseries.filter.definition.operators;

import cn.edu.thu.tsfile.timeseries.filter.definition.CrossSeriesFilterExpression;
import cn.edu.thu.tsfile.timeseries.filter.definition.FilterExpression;
import cn.edu.thu.tsfile.timeseries.filter.definition.filterseries.FilterSeries;
import cn.edu.thu.tsfile.timeseries.filter.visitorImpl.FilterVisitor;

/**
 * Both the left and right operators of CSAnd must satisfy the condition.</br>
 * CSAnd represents Cross Series And operation.
 *
 * @author CGF
 */
public class CSAnd extends CrossSeriesFilterExpression {
    public CSAnd(FilterExpression left, FilterExpression right) {
        super(left, right);
    }

    public String toString() {
        return "[" + super.left + "]" + " & [" + super.right + "]";
    }

    /**
     * Not Used
     *
     * @param visitor
     * @param <T>
     * @return
     */
    @Override
    public <T> T accept(FilterVisitor<T> visitor) {
        return null;
    }

    /**
     * Not Used
     *
     * @return
     */
    @Override
    public FilterSeries<?> getFilterSeries() {
        return null;
    }
}
