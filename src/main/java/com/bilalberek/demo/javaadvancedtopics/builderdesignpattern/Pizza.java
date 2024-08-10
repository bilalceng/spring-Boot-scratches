package com.bilalberek.demo.javaadvancedtopics.builderdesignpattern;


public class Pizza{
    private final DoughType dough;
    private final Boolean salt;
    private final WaterType water;
    private final ThicknessType thickness;
    private final Boolean sausage;
    private final Boolean tomato;
    private final  Boolean corn;
    private final Boolean mushroom;
    private final Boolean pepper;
    private final Boolean pineApple;

    private Pizza(Builder builder){
        this.dough = builder.dough;
        this.salt = builder.salt;
        this.water = builder.water;
        this.thickness = builder.thickness;
        this.sausage = builder.sausage;
        this.tomato = builder.tomato;
        this.corn = builder.corn;
        this.mushroom = builder.mushroom;
        this.pepper = builder.pepper;
        this.pineApple = builder.pineApple;
    }

    public DoughType getDough() {
        return dough;
    }

    public Boolean getSalt() {
        return salt;
    }

    public WaterType getWater() {
        return water;
    }

    public ThicknessType getThickness() {
        return thickness;
    }

    public Boolean getSausage() {
        return sausage;
    }

    public Boolean getTomato() {
        return tomato;
    }

    public Boolean getCorn() {
        return corn;
    }

    public Boolean getMushroom() {
        return mushroom;
    }

    public Boolean getPepper() {
        return pepper;
    }

    public Boolean getPineApple() {
        return pineApple;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "dough=" + dough.name() +
                ", salt=" + salt +
                ", water=" + water.name() +
                ", thickness=" + thickness.name() +
                ", sausage=" + sausage +
                ", tomato=" + tomato +
                ", corn=" + corn +
                ", mushroom=" + mushroom +
                ", pepper=" + pepper +
                ", pineApple=" + pineApple +
                '}';
    }

    public static class Builder {
        private final  DoughType dough;
        private final Boolean salt;
        private final  WaterType water;
        private ThicknessType thickness = ThicknessType.NORMAL;
        private Boolean sausage = false;
        private Boolean tomato = false;
        private Boolean corn = false;
        private Boolean mushroom = false;
        private Boolean pepper = false;
        private Boolean pineApple = false;
        public Builder(DoughType dough, Boolean salt, WaterType water){
            this.dough = dough;
            this.water = water;
            this.salt = salt;
        }

        public Builder thickness(ThicknessType thickness) {
            this.thickness = thickness;
            return this;
        }

        public Builder sausage(Boolean sausage) {
            this.sausage = sausage;
            return this;
        }

        public Builder tomato(Boolean tomato) {
            tomato = tomato;
            return this;
        }

        public Builder corn(Boolean corn) {
            this.corn = corn;
            return this;
        }

        public Builder mushroom(Boolean mushroom) {
            this.mushroom = mushroom;
            return this;
        }

        public Builder pepper(Boolean pepper) {
            this.pepper = pepper;
            return this;
        }

        public Builder pineApple(Boolean pineApple) {
            this.pineApple = pineApple;
            return this;
        }

        public Pizza build(){
            return new Pizza(this);
        }

    }
}
