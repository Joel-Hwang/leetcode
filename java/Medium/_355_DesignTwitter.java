package Medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class _355_DesignTwitter {
    public _355_DesignTwitter() {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5);
        twitter.follow(1, 2);
        twitter.follow(2, 1);
        twitter.getNewsFeed(2);
        twitter.postTweet(2,6);
        twitter.getNewsFeed(1);
        twitter.getNewsFeed(2);
        twitter.unfollow(2, 1);
        twitter.getNewsFeed(1);
        twitter.getNewsFeed(2);
        twitter.unfollow(1, 2);
        twitter.getNewsFeed(1);
        twitter.getNewsFeed(2);
        twitter.getNewsFeed(1);
        twitter.getNewsFeed(2);
               
    
    }

}

class Twitter {

    private HashMap<Integer, List<Twit>> tweets;
    private HashMap<Integer, List<Integer>> follow;
    int order = 0;
    /** Initialize your data structure here. */
    public Twitter() {
        tweets = new HashMap<>();
        follow = new HashMap<>();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        List<Twit> tweetByUserId = tweets.getOrDefault(userId, new LinkedList<>());
        tweetByUserId.add(new Twit(tweetId,order++));
        tweets.put(userId, tweetByUserId);
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in
     * the news feed must be posted by users who the user followed or by the user
     * herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        // get User List
        List<Twit> allTwits = new ArrayList<>();
        List<Integer> followees = follow.getOrDefault(userId, new ArrayList<Integer>());
        // get Feeds
        List<Twit> tweetByUserId = tweets.get(userId);
        if(tweetByUserId != null && tweetByUserId.size()>0) 
            allTwits.addAll(tweetByUserId);
        
        for (int followee : followees) {
            List<Twit> tweetByFollowee = tweets.get(followee);
            if(tweetByFollowee != null && tweetByFollowee.size()>0) 
                allTwits.addAll(tweetByFollowee);
        }

        // sort
        allTwits.sort(new Comparator<Twit>() {
            @Override
            public int compare(Twit o1, Twit o2) {

                return o2.order - o1.order;
            };
        });

        List<Integer> res = new ArrayList<>();
        for(int i = 0; i< (allTwits.size()>10?10:allTwits.size()) ;i++){
            res.add(allTwits.get(i).id);
        }

        return res;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a
     * no-op.
     */
    public void follow(int followerId, int followeeId) {
        List<Integer> followees = follow.getOrDefault(followerId, new ArrayList<>());
        for (int i = 0; i < followees.size(); i++) {
            if (followees.get(i) == followeeId)
                return;
        }
        followees.add(followeeId);
        follow.put(followerId, followees);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a
     * no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        List<Integer> followees = follow.getOrDefault(followerId, new ArrayList<>());
        for (int i = followees.size() - 1; i >= 0; i--) {
            if (followees.get(i) == followeeId){
                followees.remove(i);
                break;
            }
        }
        follow.put(followerId, followees);
    }

    class Twit{
        int id;
        int order;
        Twit(int id, int order){
            this.id = id;
            this.order = order;
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such: Twitter obj =
 * new Twitter(); obj.postTweet(userId,tweetId); List<Integer> param_2 =
 * obj.getNewsFeed(userId); obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */


 /* OO Design

 public class Twitter {
	private static int timeStamp=0;

	// easy to find if user exist
	private Map<Integer, User> userMap;

	// Tweet link to next Tweet so that we can save a lot of time
	// when we execute getNewsFeed(userId)
	private class Tweet{
		public int id;
		public int time;
		public Tweet next;

		public Tweet(int id){
			this.id = id;
			time = timeStamp++;
			next=null;
		}
	}


	// OO design so User can follow, unfollow and post itself
	public class User{
		public int id;
		public Set<Integer> followed;
		public Tweet tweet_head;

		public User(int id){
			this.id=id;
			followed = new HashSet<>();
			follow(id); // first follow itself
			tweet_head = null;
		}

		public void follow(int id){
			followed.add(id);
		}

		public void unfollow(int id){
			followed.remove(id);
		}


		// everytime user post a new tweet, add it to the head of tweet list.
		public void post(int id){
			Tweet t = new Tweet(id);
			t.next=tweet_head;
			tweet_head=t;
		}
	}




	
	public Twitter() {
		userMap = new HashMap<Integer, User>();
	}

	// Compose a new tweet.
	public void postTweet(int userId, int tweetId) {
		if(!userMap.containsKey(userId)){
			User u = new User(userId);
			userMap.put(userId, u);
		}
		userMap.get(userId).post(tweetId);

	}



	// Best part of this.
	// first get all tweets lists from one user including itself and all people it followed.
	// Second add all heads into a max heap. Every time we poll a tweet with 
	// largest time stamp from the heap, then we add its next tweet into the heap.
	// So after adding all heads we only need to add 9 tweets at most into this 
	// heap before we get the 10 most recent tweet.
	public List<Integer> getNewsFeed(int userId) {
		List<Integer> res = new LinkedList<>();

		if(!userMap.containsKey(userId))   return res;

		Set<Integer> users = userMap.get(userId).followed;
		PriorityQueue<Tweet> q = new PriorityQueue<Tweet>(users.size(), (a,b)->(b.time-a.time));
		for(int user: users){
			Tweet t = userMap.get(user).tweet_head;
			// very imporant! If we add null to the head we are screwed.
			if(t!=null){
				q.add(t);
			}
		}
		int n=0;
		while(!q.isEmpty() && n<10){
		  Tweet t = q.poll();
		  res.add(t.id);
		  n++;
		  if(t.next!=null)
			q.add(t.next);
		}

		return res;

	}

	// Follower follows a followee. If the operation is invalid, it should be a no-op. 
	public void follow(int followerId, int followeeId) {
		if(!userMap.containsKey(followerId)){
			User u = new User(followerId);
			userMap.put(followerId, u);
		}
		if(!userMap.containsKey(followeeId)){
			User u = new User(followeeId);
			userMap.put(followeeId, u);
		}
		userMap.get(followerId).follow(followeeId);
	}

	/ Follower unfollows a followee. If the operation is invalid, it should be a no-op. 
	public void unfollow(int followerId, int followeeId) {
		if(!userMap.containsKey(followerId) || followerId==followeeId)
			return;
		userMap.get(followerId).unfollow(followeeId);
	}
}

 
 
 */