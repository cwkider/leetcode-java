/**
 * @FileName : Solution.java
 * @Date : 2022. 4. 23.
 * @Problem Title : 4. Median of Two Sorted Arrays
 */package problems.leetpr00004;

public class Solution {
    public static void main(String[] args) {
        Solution st = new Solution();

        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        //Output : 2.0
        System.out.println("1 | 2.0 | ==================================");
        System.out.println(st.findMedianSortedArrays(nums1, nums2));

        int[] nums3 = {1, 2};
        int[] nums4 = {3, 4};
        //Output : 2.5
        System.out.println("2 | 2.5 | ==================================");
        System.out.println(st.findMedianSortedArrays(nums3, nums4));

        int[] nums5 = {};
        int[] nums6 = {1};
        //Output : 1.0
        System.out.println("3 | 1.0 | ==================================");
        System.out.println(st.findMedianSortedArrays(nums5, nums6));

        int[] nums7 = {1, 2, 3};
        int[] nums8 = {4, 5, 7};
        //Output : 3.5
        System.out.println("4 | 3.5 | ==================================");
        System.out.println(st.findMedianSortedArrays(nums7, nums8));

        int[] nums9 = {1, 2, 3, 4};
        int[] nums10 = {5, 7};
        //Output : 3.5
        System.out.println("5 | 3.5 | ==================================");
        System.out.println(st.findMedianSortedArrays(nums9, nums10));

        int[] nums11 = {1};
        int[] nums12 = {1};
        //Output : 1.0
        System.out.println("6 | 1.0 | ==================================");
        System.out.println(st.findMedianSortedArrays(nums11, nums12));

        int[] nums13 = {1, 2};
        int[] nums14 = {3,4,5,6};
        //Output : 3.5
        System.out.println("7 | 3.5 | ==================================");
        System.out.println(st.findMedianSortedArrays(nums13, nums14));

        int[] nums15 = {5, 6};
        int[] nums16 = {1,2,3,4,7,8};
        //Output : 4.5
        System.out.println("8 | 4.5 | ==================================");
        System.out.println(st.findMedianSortedArrays(nums15, nums16));

        int[] nums17 = {2,2,4,4};
        int[] nums18 = {2,2,4,4};
        //Output : 3.0
        System.out.println("9 | 3.0 | ==================================");
        System.out.println(st.findMedianSortedArrays(nums17, nums18));

        int[] nums19 = {1,2};
        int[] nums20 = {1,2};
        //Output : 1.5
        System.out.println("10 | 1.5 | ==================================");
        System.out.println(st.findMedianSortedArrays(nums19, nums20));

        int[] nums21 = {1,2};
        int[] nums22 = {1,1};
        //Output : 1.0
        System.out.println("11 | 1.0 | ==================================");
        System.out.println(st.findMedianSortedArrays(nums21, nums22));
        int[] nums23 = {6};
        int[] nums24 = {1,2,3,4,5,7};
        //Output : 4.0
        System.out.println("12 | 4.0 | ==================================");
        System.out.println(st.findMedianSortedArrays(nums23, nums24));

    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double ret = 0.0;

        int lng1 = nums1.length;
        int lng2 = nums2.length;
        int lngsum = lng1 + lng2;

        if(lng1 == 0) {
            ret = nums2[lng2/2];
            if(lng2 % 2 == 0)
                return (ret + nums2[lng2/2 - 1]) / 2.0;
            else return ret;
        }

        if(lng2 == 0) {
            ret = nums1[lng1/2];
            if(lng1 % 2 == 0)
                return (ret + nums1[lng1/2 - 1]) / 2.0;
            else return ret;
        }

        int mid = lngsum / 2;
        if (nums1[0] >= nums2[lng2-1]) {
            if (lngsum % 2 != 0) {
                mid += 1;
                if (lng2 >= mid) return nums2[mid-1] * 1.0;
                else {
                    mid -= lng2;
                    return nums1[mid-1] * 1.0;
                }
            } else {
                if (lng2 == mid) return (nums2[mid-1] + nums1[0]) / 2.0;
                else if (lng2 > mid) return (nums2[mid-1] + nums2[mid]) / 2.0;
                else {
                    mid -= lng2;
                    return (nums1[mid-1] + nums1[mid]) / 2.0;
                }
            }
        }

        if (nums2[0] >= nums1[lng1-1]) {
            if (lngsum % 2 != 0) {
                mid += 1;
                if (lng1 >= mid) return nums1[mid-1];
                else {
                    mid -= lng1;
                    return nums2[mid-1];
                }
            } else {
                if (lng1 == mid) return (nums1[mid-1] + nums2[0]) / 2.0;
                else if (lng1 > mid) return (nums1[mid-1] + nums1[mid]) / 2.0;
                else {
                    mid -= lng1;
                    return (nums2[mid-1] + nums2[mid]) / 2.0;
                }
            }
        }

        if (lngsum % 2 != 0) mid++;
        ret = getMedian(nums1, nums2, lng1, lng2, mid);
        if (ret < 0.0) ret = getMedian(nums2, nums1, lng2, lng1, mid);
        if (lngsum % 2 == 0) {
            mid += 1;
            double ret2 = getMedian(nums1, nums2, lng1, lng2, mid);
            if (ret2 < 0.0) ret2 = getMedian(nums2, nums1, lng2, lng1, mid);
            ret = (ret + ret2) / 2;
        }

        return ret;
    }

    public double getMedian(int[] nums1, int[] nums2, int lng1, int lng2, int mid) {
        double ret = -1.0;

        int start = 0;
        int end = lng1 - 1;
        int mid1 = 0, mid2 = 0;
        while (end >= start) {
            mid1 = (start + end) / 2;
            mid2 = mid - mid1 - 1;
            if (mid2 < 0) mid2 = 0;
            else if (mid2 >= lng2) mid2 = lng2 - 1;
            if (nums1[mid1] <= nums2[mid2]) {
                if (mid2 == 0) {
                    if (mid - 1 == mid1 + mid2) {
                        ret = nums1[mid1];
                        break;
                    }
                }
                else if (nums1[mid1] >= nums2[mid2-1]) {
                    if (mid - 1 == mid1 + mid2) {
                        ret = nums1[mid1];
                        break;
                    }
                }
                if(mid2 == 0 && mid1 > mid - 1) end = mid1 - 1;
                else start = mid1 + 1;
            } else { //nums1[mid1] > nums2[mid2]
                if (mid - 1 == mid1 + mid2 + 1) {
                    ret = nums1[mid1];
                    break;
                }
                if(mid2 == lng2 - 1 && mid1 + mid2 + 1 < mid - 1) start = mid1 + 1;
                else end = mid1 - 1;
            }
        }

        return ret;
    }
}
