package edu.vanderbilt.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExerciseApplicationTests {

	@Autowired
	VideoService videoService;
	
	@Test
	public void contextLoads() {	
	}
	
	@Test
	public void videoServiceLoaded() {
		assertNotNull(videoService);
	}
	
	@Test
	public void addVideoReturnsAListOfVideos() {
		Video video = new Video();
		Iterable<Video> videos = videoService.addVideo(video);
		assertNotNull(videos);
		assertTrue(videos.iterator().hasNext());
	}
	
	@Test
	public void testGetAllVideos() {
		Iterable<Video> videos = videoService.getAllVideos();
		assertNotNull(videos);
		assertTrue(videos.iterator().hasNext());
	}
	
	@Test 
	public void testPostVideo() {
		Video video = new Video();
		Iterable<Video> videos = videoService.addVideo(video);
		assertNotNull(videos);
		assertTrue(videos.iterator().hasNext());
	}
	
	@Test
	public void testDeleteVideo() {
		Video video = new Video();
		video.setName("Original");
		videoService.addVideo(video);
		assertNotNull(videoService.getVideo(video.getId()));
		
		videoService.deleteVideo(video.getId());
		
		assertNull(videoService.getVideo(video.getId()));
	}
}
