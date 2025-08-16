#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    int maximumUnits(vector<vector<int>>& boxTypes, int truckSize) {
        sort(boxTypes.begin(), boxTypes.end(), [](const vector<int>& a, const vector<int>& b){
            return a[1] > b[1];
        });

        int maxUnits = 0;
        for (auto& box : boxTypes) {
            if (truckSize == 0) break;

            int boxesTaken = min(truckSize, box[0]);
            truckSize -= boxesTaken;
            maxUnits += box[1] * boxesTaken;
        }

        return maxUnits;
    }
};