package Medium;

import java.util.Arrays;

import org.testng.annotations.Test;

public class _611_ValidTriangleNumber {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (isTriangle(nums[i], nums[j], nums[k]))
                        res++;
                    else
                        break;
                }
            }
        }
        return res;
    }

    public int triangleNumber2(int[] nums){
        int res = 0;
        Arrays.sort(nums);
        int n = nums.length;
        for(int i = n-1; i>=0; i--){
           int l = 0, r = i-1;
           while(l<r){
               if(nums[l]+nums[r] > nums[i]){
                   res += r-l;
                   r--;
               }
               else l++;
           }
        }
        return res;
    }

    public boolean isTriangle(int a, int b, int c) {
        return c < b + a;
    }

    @Test
    public void test() {
        System.out.println(triangleNumber2(new int[] { 2, 2, 3, 4 }));
        System.out.println(triangleNumber2(new int[] { 4, 2, 3, 4 }));
        System.out.println(triangleNumber2(new int[] { 278, 513, 154, 216, 742, 535, 172, 176, 159, 698, 622, 156, 80,
                632, 254, 233, 330, 346, 682, 908, 802, 869, 74, 104, 142, 450, 116, 233, 195, 334, 540, 491, 910, 720,
                456, 873, 130, 833, 935, 853, 319, 169, 85, 496, 378, 25, 859, 364, 832, 592, 950, 610, 478, 898, 221,
                291, 441, 803, 567, 986, 283, 978, 446, 735, 796, 944, 217, 95, 109, 649, 761, 536, 640, 155, 902, 50,
                897, 791, 604, 14, 609, 577, 731, 606, 742, 253, 667, 492, 922, 955, 185, 823, 282, 379, 821, 157, 319,
                2, 857, 198, 531, 496, 978, 436, 459, 973, 481, 610, 8, 220, 809, 431, 831, 559, 694, 240, 871, 804,
                682, 133, 305, 45, 447, 852, 102, 134, 585, 247, 118, 802, 530, 443, 167, 115, 68, 664, 33, 569, 470,
                494, 827, 43, 794, 412, 403, 133, 935, 912, 341, 870, 576, 923, 350, 479, 472, 119, 339, 46, 858, 60,
                817, 733, 613, 57, 271, 767, 477, 426, 986, 537, 64, 569, 179, 543, 118, 863, 703, 191, 675, 967, 300,
                185, 618, 642, 139, 170, 154, 449, 187, 318, 770, 228, 233, 699, 641, 752, 949, 145, 855, 383, 475, 539,
                481, 7, 400, 723, 52, 983, 217, 169, 336, 767, 468, 529, 676, 798, 444, 62, 164, 438, 451, 749, 962,
                243, 220, 492, 740, 579, 653, 3, 72, 642, 843, 963, 777, 46, 125, 721, 295, 111, 201, 653, 452, 494, 89,
                951, 483, 26, 212, 718, 760, 640, 410, 827, 734, 412, 390, 207, 57, 657, 91, 743, 969, 89, 511, 604,
                689, 346, 530, 209, 54, 823, 267, 402, 975, 772, 74, 867, 124, 135, 359, 337, 674, 183, 673, 535, 217,
                689, 249, 267, 459, 963, 870, 879, 984, 888, 91, 655, 30, 963, 101, 202, 199, 596, 915, 594, 765, 212,
                778, 285, 781, 722, 539, 624, 991, 939, 788, 12, 915, 84, 972, 607, 754, 654, 796, 514, 973, 284, 594,
                377, 787, 547, 870, 752, 859, 62, 752, 365, 869, 646, 88, 323, 601, 26, 624, 241, 674, 363, 665, 45,
                933, 260, 700, 798, 349, 335, 40, 250, 532, 538, 886, 54, 375, 930, 405, 661, 882, 915, 820, 636, 519,
                837, 65, 534, 157, 806, 604, 350, 169, 272, 17, 409, 176, 485, 701, 447, 443, 900, 78, 517, 815, 792, 4,
                307, 510, 600, 409, 295, 803, 96, 271, 184, 405, 140, 891, 61, 202, 424, 251, 18, 125, 882, 312, 721,
                632, 346, 88, 781, 640, 702, 611, 475, 365, 364, 9, 777, 870, 963, 504, 548, 872, 565, 591, 624, 37,
                778, 875, 498, 504, 576, 135, 271, 83, 525, 623, 504, 190, 187, 645, 998, 860, 413, 482, 242, 634, 234,
                176, 941, 968, 694, 827, 841, 598, 87, 846, 797, 395, 83, 740, 591, 738, 977, 353, 328, 26, 595, 320,
                210, 240, 748, 930, 865, 430, 572, 977, 655, 724, 74, 378, 604, 380, 432, 8, 917, 982, 726, 112, 90,
                678, 31, 866, 90, 974, 651, 89, 771, 67, 514, 570, 817, 174, 842, 610, 442, 35, 141, 181, 88, 524, 83,
                100, 165, 537, 669, 194, 603, 281, 321, 176, 455, 945, 506, 5, 433, 711, 170, 828, 291, 817, 855, 706,
                851, 732, 981, 600, 168, 110, 330, 930, 457, 120, 848, 435, 113, 250, 124, 51, 527, 18, 42, 964, 370,
                801, 631, 21, 154, 821, 564, 373, 326, 457, 365, 624, 778, 370, 356, 912, 164, 192, 139, 385, 863, 443,
                800, 815, 526, 337, 803, 401, 153, 171, 511, 636, 672, 663, 548, 421, 595, 427, 556, 894, 450, 193, 495,
                406, 99, 642, 976, 246, 710, 531, 923, 741, 62, 681, 835, 148, 411, 19, 942, 425, 762, 429, 769, 950,
                188, 205, 31, 766, 82, 614, 602, 804, 981, 666, 134, 750, 107, 619, 554, 597, 577, 52, 744, 837, 207,
                754, 959, 310, 857, 365, 310, 656, 764, 850, 627, 35, 829, 792, 736, 474, 255, 111, 759, 891, 296, 717,
                301, 412, 212, 35, 879, 963, 47, 938, 431, 689, 257, 505, 521, 790, 218, 729, 303, 311, 610, 659, 713,
                555, 531, 234, 452, 982, 512, 554, 732, 40, 902, 731, 478, 10, 159, 473, 38, 725, 783, 385, 69, 522,
                991, 836, 303, 946, 819, 687, 568, 5, 768, 99, 884, 754, 400, 27, 128, 277, 457, 577, 470, 306, 5, 52,
                163, 372, 173, 526, 731, 732, 230, 824, 819, 517, 517, 901, 291, 725, 436, 804, 658, 909, 782, 911, 243,
                330, 821, 404, 901, 188, 737, 259, 54, 457, 910, 524, 172, 142, 951, 132, 743, 316, 309, 87, 813, 521,
                738, 156, 989, 735, 543, 914, 331, 938, 149, 47, 919, 422, 281, 245, 350, 35, 375, 241, 171, 884, 261,
                374, 79, 980, 980, 386, 738, 215, 368, 514, 127, 597, 997, 367, 813, 466, 821, 521, 433, 529, 784, 151,
                108, 526, 832, 731, 402, 485, 218, 261, 382, 313, 338, 738, 558, 603, 311, 340, 696, 283, 907, 99, 132,
                244, 912, 506, 523, 115, 251, 235, 1, 576, 945, 806, 372, 214, 702, 548, 270, 936, 938, 153, 182, 210,
                718, 951, 402, 327, 574, 698, 613, 960, 98, 806, 423, 553, 150, 753, 301, 176, 425, 475, 884, 420, 749,
                231, 212, 755, 140, 33, 740, 353, 57, 563, 328, 106, 315, 534, 938, 31, 679, 105, 599, 133, 702, 548,
                543, 85, 57, 179, 159, 84, 98, 789, 284, 288, 426, 791, 836, 907, 883, 59, 703, 836, 872, 821, 34, 51,
                522, 620, 418, 739, 783, 184, 470, 485, 416, 710, 306, 241, 799, 540, 98, 462, 532, 682, 490, 336, 384,
                911, 700, 62, 139, 469, 946, 949, 209, 385, 359, 150, 810, 338, 197, 834, 84, 915, 999, 1000, 819, 896,
                843, 98, 99, 575 }));
    }
}