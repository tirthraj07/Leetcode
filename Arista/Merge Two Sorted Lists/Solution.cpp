#include <bits/stdc++.h>
using namespace std;


struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

class Solution {
public:
    ListNode* mergeTwoLists(ListNode* list1, ListNode* list2) {
        if(list1 == NULL){
            return list2;
        } else if(list2 == NULL){
            return list1;
        }
        
        ListNode* head = nullptr;
        if(list1->val < list2->val){
            head = new ListNode(list1->val);
            head->next = mergeTwoLists(list1->next, list2);
        } else {
            head = new ListNode(list2->val);
            head->next = mergeTwoLists(list1, list2->next);
        }

        return head;
    }
};