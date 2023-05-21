import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>>ans=new ArrayList<>();
        int i=0;
        int n=nums.length;
        while(i<n){
            int j=i+1;
            while(j<n)
            {
                long newTar=1L*(target-((long)(nums[i]+nums[j])));
                int l=j+1;
                int r=n-1;
                while(l<r){
                    long csum=nums[l]+nums[r];
                    if(csum==newTar)
                    {
                        List<Integer> res=new ArrayList<>();
                        res.add(nums[i]);
                        res.add(nums[j]);
                        res.add(nums[l]);
                        res.add(nums[r]);
                        ans.add(res);

                        l++;
                        while(l<n && nums[l]==nums[l-1])l++;

                        r--;
                        while(r>=0 && nums[r]==nums[r+1])r--;
                    }
                    else if(csum < newTar){
                        l++;
                        while(l<n && nums[l]==nums[l-1])l++;
                    }
                    else{
                        r--;
                        while(r>=0 && nums[r]==nums[r+1])r--;
                    }
                }
                j++;
                while(j<n && nums[j]==nums[j-1])j++;

            }
            i++;
            while(i<n && nums[i]==nums[i-1])i++;
        }
        return ans;
    }
}
