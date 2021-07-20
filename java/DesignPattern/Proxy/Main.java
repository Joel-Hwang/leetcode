package DesignPattern.Proxy;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Thumbnail> thumbnails = new ArrayList<>();
        thumbnails.add(new ProxyThumbnail("GIT 강좌","/git.mp4"));
        thumbnails.add(new ProxyThumbnail("REST API란?","/rest-api.mp4"));
        thumbnails.add(new ProxyThumbnail("도커 사용법","/docker.mp4"));
        thumbnails.add(new ProxyThumbnail("객체지향 프로그래밍","/oop.mp4"));
        thumbnails.add(new ProxyThumbnail("블록체인의 원리","/blockchain.mp4"));

        for(Thumbnail thumbnail : thumbnails){
            thumbnail.showTitle(); //화면에 비디오의 제목만 보여준다.
        }

        //커서가 올라오면 Preview를 재생한다.
        //무거운 영상에 대한 처리는 RealThumbnail이 하는 것이 핵심
        thumbnails.get(2).showPreview();
        thumbnails.get(3).showPreview();
        thumbnails.get(4).showPreview();
        thumbnails.get(1).showPreview();
        thumbnails.get(0).showPreview();
    }
}
