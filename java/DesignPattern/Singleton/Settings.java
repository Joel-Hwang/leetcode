package DesignPattern.Singleton;

public class Settings {
    private Settings(){} //private 생성자

    private static Settings settings = null;  //자기 자신을 정적변수로.

    public static Settings getSettings(){  //처음 호출할때 private 생성자로 객체 생성. 그 이후엔 정적변수 리턴
        if( settings == null){
            settings = new Settings();
        }
        return settings;
    }

    public void print(){
        System.out.println("address : " + this.toString());
    }
}
