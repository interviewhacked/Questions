/**
 * Given a singly connected linked list, find the largest palindrome in the list in O(1) space.
 */





/**
 * For each node in 'n' the linked list reverse the list upto 'n'
 * and then check if there is a odd or even length palindrome
 * at 'n'.
 */

int count_common(ListNode *a, ListNode *b)
{
    int ret = 0;

    for (; a && b; a = a->next, b = b->next)
        if (a->data == b->data)
            ++ret;
        else
            break;

    return ret;
}

int max_palindrome(ListNode *head)
{
    int ret = 0;
    ListNode *p = nullptr, *q = head;

    while (q)
    {
        auto t = q->next;

        q->next = p;

        ret = max(ret, 2 * count_common(p, t) + 1);
        ret = max(ret, 2 * count_common(q, t));

        p = q;
        q = t;
    }

    return ret;
}

