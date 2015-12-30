/**
 * If all the values in a BST are unique then to check whether it contains a loop or 
 * not(same as checking whether a tree is BST or not but all the elements should be unique):
 */






is_loopless_bst(min, max, root) 
{ 
  if (root==null) 
	return true; 
  if(min < root->value < max) 
	return is_loopless_bst(min, root->value, root->left) && is_loopless_bst(root->value, max, root->right); 
  else 
	return false; 
} 
 
//call with: is_loopless_bst(-inf, inf, tree) 


node* next(node *cur, stack& st)
{
  if(cur->left)
  {
    if(cur->right)
       st.push(cur->right)
    return cur->left
  }
  else if ( !st.empty() )
    return st.pop();
  else
    return NULL;
}
 
 
node* find_loop( node * root)  // assuming there is a loop, otherwise check for there not being a next;
{
  stack st1, st2;
  node* pt1, pt2;
 
  pt1 = root;
  pt2 = next(root, st2);
 
  while (pt1 != pt2)
  {
    pt1 = next(pt1, st1);
    pt2 = next(next(pt2, st2), st2);	
  }
 
  pt1 = root;
  pt2 = next(pt2, st2);
 
  while (pt1 != pt2)
  {
    pt1 = next(pt1, st1);
    pt2 = next(pt2, st2);	
  }
 
  return pt1;
}

 
The next() function lets you approach the tree as a linked list (in this case of nodes in preorder). Thus reducing the problem of finding a loop in a tree to finding a loop in a linked list. 

