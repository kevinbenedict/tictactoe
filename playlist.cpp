#include<iostream>
#include<string>
#include<conio.h>
using namespace std;

class node {
private:
	char data[100];
	bool nowplaying;
	node* next, *prev;

public:
	node()
	{
		next = NULL;
		prev = NULL;
	}

	void get(char* str)
	{
		strcpy(str,data);
	}

	void set(char x[])
	{
		strcpy(data,x);
	}

	node* nget()
	{
		return (next);
	}

	node* pget()
	{
		return (prev);
	}

	void nset(node* nextnode)
	{
		next = nextnode;
	}

	void pset(node* prevnode)
	{
		prev = prevnode;
	}

	void setnowplay(bool x)
	{
		nowplaying = x;
	}

	bool getnowplay()
	{
		return nowplaying;
	}
};

class dlinkedlist {
private:
	node* head, *tail;

public:
	dlinkedlist()
	{
		head = NULL;
		tail = NULL;
	}

	void add(char* data)
	{
		node* _node;
		_node = new node;
		_node->set(data);

		if (!head)
		{
			head = _node;
			tail = _node;
			_node->setnowplay(1);
		}

		else {
			tail->nset(_node);
			_node->pset(tail);
			tail = _node;
			tail->nset(head);
			head->pset(tail);
			_node->setnowplay(0);
		}
	}

	void view()
	{
		node* temp;
		temp = head;
		char tem[100];

		while (temp)
		{
			temp->get(tem);
			cout << tem << " ";
			if (temp->getnowplay()) cout << "*";

			cout << endl;
			if (temp->nget() == head) break;
			temp = temp->nget();
		}
	}

	void delsong(int in)
	{
		node* temp = new node;
		temp = head;
		int i = 0;

		if(head)
		{
			while (temp)
			{
				temp = temp->nget();
				i++;

				if (temp->nget() == head) break;
			}

			if (i < in)
			{
				cout << "Index tidak valid\n";
				_getch();
			}

			else {
				temp = head;
				i = 0;
				while (i != in)
				{
					temp = temp->nget();
					i++;
				}

				if (temp->getnowplay()) movenowplay("next");

				if (temp == head)
				{
					temp = temp->nget();
					head = temp;
					temp = temp->pget();
				}

				if (temp == tail)
				{
					temp = temp->pget();
					tail = temp;
					temp = temp->nget();
				}

				temp->pget()->nset(temp->nget());
				temp->nget()->pset(temp->pget());
			}
		}

		else 
		{
			cout << "Playlist kosong\n";
			getch();
		}
	}

	void movenowplay(string direction)
	{
		node* temp = new node;
		temp = head;

		while (temp)
		{
			if (temp->getnowplay())
			{
				if (direction == "next")
				{
					temp->setnowplay(0);
					temp = temp->nget();
					temp->setnowplay(1);
				}

				else if (direction == "prev")
				{
					temp->setnowplay(0);
					temp = temp->pget();
					temp->setnowplay(1);
				}
			}

			if (temp->nget() == head) break;
			temp = temp->nget();
		}
	}

	void swap(int x, int y)
	{
		node* temp = new node;
		node* temp1 = new node;
		node* temp2 = new node;
		temp = head;
		int i = 0;

		while (temp)
		{
			if (i == x)
			{
				temp1 = temp;
			}

			else if (i == y)
			{
				temp2 = temp;
			}

			temp = temp->nget();
			i++;
			if (temp->nget() == head)
			{
				if (i == x)
				{
					temp1 = temp;
				}

				else if (i == y)
				{
					temp2 = temp;
				}

				break;
			}
		}

		if (temp1 == head) head = temp2;
		else if (temp2 == head) head = temp1;
		else if (temp1 == tail) tail = temp2;
		else if (temp2 == tail) tail = temp1;

		node* a = new node;
		node* b = new node;
		node* c = new node;
		node* d = new node;

		if (i == 1)
		{
			head = temp2;
			tail = temp1;
		}

		else if (x == y-1)
		{
			temp1->pget()->nset(temp2);
			temp2->nget()->pset(temp1);
			temp1->nset(temp2->nget());
			temp1->pset(temp2);
			temp2->nset(temp1);
			temp2->pset(temp1->pget());
		}

		else {
			a = temp1->pget();
			b = temp1->nget();
			c = temp2->pget();
			d = temp2->nget();

			a->nset(temp2);
			b->pset(temp2);
			c->nset(temp1);
			d->pset(temp1);
			temp2->pset(a);
			temp2->nset(b);
			temp1->pset(c);
			temp1->nset(d);
		}
	}
};

void main()
{
	dlinkedlist list;

	int ch = 1, index1, index2;
	char title[100];

	while (true)
	{
		list.view();
		cout << endl << endl;
		cout << "1. Tambah Lagu\n";
		cout << "2. Hapus Lagu\n";
		cout << "3. Next\n";
		cout << "4. Prev\n";
		cout << "5. Shuffle\n";
		cout << "6. Swap\n";
		cout << "0. Exit\n";
		fflush(stdin);
		cin>>ch;

		if (ch == 0)
		{
			break;
		}
		else if (ch == 1)
		{
			cout<<"Judul lagu: ";
			fflush(stdin);
			gets_s(title);
			list.add(title);
		}

		else if (ch == 2)
		{
			cout << "Index lagu yg ingin dihapus: ";
			cin >> index1;
			list.delsong(index1);
		}

		else if (ch == 3)
		{
			list.movenowplay("next");
		}

		else if (ch == 4)
		{
			list.movenowplay("prev");
		}

		else if (ch == 5)
		{

		}

		else if (ch == 6)
		{
			cout << "Index lagu pertama: ";
			cin >> index1;
			cout << "Index lagu kedua: ";
			cin >> index2;

			if (index1 > index2)
			{
				int tem = index1;
				index1 = index2;
				index2 = tem;
			}

			if (index1 == index2) cout << "Index harus berbeda\n";
			else list.swap(index1, index2);
		}

		else {
			cout << "Input tidak valid\n";
			_getch();
		}

		system("CLS");
	}
}