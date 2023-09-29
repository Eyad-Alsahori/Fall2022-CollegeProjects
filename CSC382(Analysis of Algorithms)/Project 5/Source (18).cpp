#include <iostream>
using namespace std;

struct node
{
    int vertex;
    node* next;
};

//declaring variables
int n;   
int e;   
int i, j, k;   
bool* Visited;
bool cycles = false;  

class Graph{
private:
    int vertex1;
    int vertex2;

public:
    node* headnodes;
    Graph(int nodes) // constructor
    {
        n = nodes;
        headnodes = new node[n]; // headnodes is an array of nodes.
        for (i = 0; i < n; i++)
        {
            headnodes[i].vertex = i;
            headnodes[i].next = 0;
        }
    }

    void create()
   {
        node* previousNode;
        node* newNode;
        cout << "\nThe Number of edges: " << endl;
        cin >> e;
        cout << "\nTo find the cycle, Enter a pair of vertices which are vert(x) and Vert (y)\n";
        for (i = 1; i <= e; i++)
        {
            cout << "Edge: " << i << "\nvert(x) :";
            cin >> vertex1;
            cout << "vert(y) :";
            cin >> vertex2;
            cout << endl;

            newNode = new node;
            newNode->vertex = vertex2;

            if (headnodes[vertex1].next == NULL)  {
                newNode->next = NULL;
                headnodes[vertex1].next = newNode;
            }
            else{
                previousNode = &headnodes[vertex1];
                while (previousNode->next != NULL)
                {
                    previousNode = previousNode->next;
                }
                newNode->next = NULL;
                previousNode->next = newNode;
            }

            
            newNode = new node;
            newNode->vertex = vertex1;

            if (headnodes[vertex2].next == NULL)
            {
                newNode->next = NULL;
                headnodes[vertex2].next = newNode;
            }
            else
            {
                previousNode = &headnodes[vertex2];
                while (previousNode->next != NULL)
                {
                    previousNode = previousNode->next;
                }
                newNode->next = NULL;
                previousNode->next = newNode;
            }
        }
    }

    void DFS(int parent, int v){
        Visited[v] = true;
        node* adjacentNode = headnodes[v].next;
        while (adjacentNode)
        {
            if (!Visited[adjacentNode->vertex]) {
                DFS(v, adjacentNode->vertex);
            }
            else if (parent != adjacentNode->vertex)  
            {
                cycles = true;
            }
            adjacentNode = adjacentNode->next;
        }
    }

    void print()  {
        node* tempNode;
        cout << "The cycles for this graph are:  \n";
        for (i = 0; i < n; i++)
        {
            tempNode = &headnodes[i];
            while (tempNode != NULL)              
            {
                cout << tempNode->vertex << ",";
                tempNode = tempNode->next;

            }
            cout << endl;
        }
    }
};

int main()
{
    cout << "The Number of Vertices: " << endl;
    cin >> n;
    Visited = new bool[n];
    int Nmbrcmpnts = 0; 

    Graph G(n); 
    G.create(); 
    G.print();
    for (i = 0; i <= n; i++)
    {
        Visited[i] = false;
    }
    for (i = 0; i < n; i++)
    {
        Visited[i] = false;
        for (j = 0; j < n; j++)
        {
            if (!Visited[j])
            {
                G.DFS(0, j);
                Nmbrcmpnts++;
            }
        }
        cout << "The number of components in the graph is " << Nmbrcmpnts << endl;
        if (cycles)
            cout << "This graph has a cycle!\n";
        else
            cout << "This graph does not contain any cycles\n";
        return 0;
    }
}
