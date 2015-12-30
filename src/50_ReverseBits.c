int reverseBits(int a){
    unsigned int up = ~0;
    up >>=1;
    up = ~up;
    unsigned int low = 1;
    for(;up>low;up>>=1,low<<=1){
        int temp = a;
        if(temp&up){
            a|=low;
        }else{
            a&=~low;
        }
        if(temp&low){
            a|= up;
        }else{
            a&=~up;
        }      
    }
    printf("%u\n",a);
}

