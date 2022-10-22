package com.aor.numbers;

public class DivisibleByFilter implements GenericListFilter{

    private int divider;

    DivisibleByFilter(int divider){
        this.divider = divider;
    }

    @Override
    public boolean accept(Integer number) {
        if((number % divider) == 0 )
            return true;
        return false;
    }
}
