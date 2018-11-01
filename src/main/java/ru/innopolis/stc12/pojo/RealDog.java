package ru.innopolis.stc12.pojo;

import java.util.List;

public class RealDog extends Dog {
    private Dog mather;
    private Dog father;
    private List<Dog> childs;

    public Dog getMather() {
        return mather;
    }

    public void setMather(Dog mather) {
        this.mather = mather;
    }

    public Dog getFather() {
        return father;
    }

    public void setFather(Dog father) {
        this.father = father;
    }

    public List<Dog> getChilds() {
        return childs;
    }

    public void setChilds(List<Dog> childs) {
        this.childs = childs;
    }
}
