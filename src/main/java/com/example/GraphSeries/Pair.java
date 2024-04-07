package com.example.GraphSeries;

public class Pair implements Comparable<Pair> {

    public int wsf;
    public String psf;

    public Pair(int wsf, String psf) {
        this.wsf = wsf;
        this.psf = psf;
    }

    @Override
    public int compareTo(Pair o) {
        return this.wsf - o.wsf;
    }
}
