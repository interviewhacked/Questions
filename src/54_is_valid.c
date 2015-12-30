/**
 * The following function checks if test string is made of characters only from alphabet 
 * string. Both test and alphabet strings are assumed to be null terminated and alphabet
 * contains only unique charaters.
 * The worst case time complexity is O(length(alphabet) + length(test))
 * Even though there are two nested loops each character in alphabet is processed once
 * and once processed all corresponding characters in test string get checked in constant
 * time.
 * Optimized for the case when all the charaters in test string occur towards the begining 
 * in alphabet string.
 */

#include<stdio.h>
#include<string.h>
#include<assert.h>

#define CHAR_SET_SIZE 256

int isValid(char *alphabet, char *test){
    if(!alphabet){
        return !test || !test[0];
    }
    if(!test){
        return 0;
    }
    
    int i = 0;
    int alphabetIndex = 0;
    char char_set[CHAR_SET_SIZE];
    memset(char_set, 0, CHAR_SET_SIZE);

    for(;test[i];++i){
        while(!char_set[test[i]] && alphabet[alphabetIndex]){
            char_set[alphabet[alphabetIndex++]] = 1;
        }
        if(!char_set[test[i]]){
            return 0;
        }
    }
    return 1;
}

int main(){
    assert(1==isValid(NULL, NULL));
    assert(0==isValid(NULL, "a"));
    assert(0==isValid("a", NULL));
    assert(1==isValid("abcdef","aaaabbbb"));
    assert(1==isValid("abcdef","aaaabbbbe"));
    assert(0==isValid("abcdef","aaaabbbbedddddgf"));
    assert(0==isValid("abcdef","daegfab"));
    assert(1==isValid("abcdef","ffeeeddccbbbca"));
    return 0;
}
