void *aligned_malloc(size_t bytes,size_t alignment)
{
    void *mem_block = malloc(bytes + alignment + sizeof(size_t *) );
    if(!mem_block)
    {
	return NULL;
    }
    void *shifted_block = mem_block + sizeof(size_t *);
    void *aligned_block = (void*)((uintptr_t)(shifted_block + alignment - 1 ) & ~(alignment-1));
    
    mem_block = aligned_block - sizeof(size_t *);
    *((size_t*)mem_block) = mem_block;
    return aligned_block;
}

void aligned_free(void *p)
{
    if(!p)
    {
	return;
    }
    free(*((size_t*)(p - sizeof(size_t *))));

}
