package DesignPattern.Adapter;

interface FindAlgorithm{
    public void find(boolean global);
}

class FindAlgo implements FindAlgorithm{
    @Override
    public void find(boolean global) {
        System.out.println("find movie " + (global?"Globally":"locally"));
    }
}
