package com.example.courses_management_service.model;

public class Ratings {
    private Double average;
    private Integer count;

    public Ratings() {
    }

    public Ratings(Double average, Integer count) {
        this.average = average;
        this.count = count;
    }


    public Double getAverage() {
        return average;
    }

    public void setAverage(Double average) {
        this.average = average;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ratings ratings = (Ratings) o;

        if (average != null ? !average.equals(ratings.average) : ratings.average != null) return false;
        return count != null ? count.equals(ratings.count) : ratings.count == null;
    }

    @Override
    public int hashCode() {
        int result = average != null ? average.hashCode() : 0;
        result = 31 * result + (count != null ? count.hashCode() : 0);
        return result;
    }


}