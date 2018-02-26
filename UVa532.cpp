#include <iostream>
#include <cstdio>
#include <queue>

using namespace std;

int moves[6][3] = {
	{0,1,0},
	{1,0,0},
	{0,0,1},
	{0,-1,0},
	{-1,0,0},
	{0,0,-1}
};

struct Point
{
	int x;
	int y;
	int z;
};

char dungeons[31][31][31];
int walk[31][31][31];
int l,r,c;


int BFS(int startPos[]) {
	queue<struct Point> q;
	struct Point start;
	start.x = startPos[0];
	start.y = startPos[1];
	start.z = startPos[2];

	dungeons[start.x][start.y][start.z] = '#';
	q.push(start);

	walk[start.x][start.y][start.z] = 0;

	while(!q.empty()) {
		struct Point curPoint = q.front();
		q.pop();
		
		for(int i = 0 ; i < 6 ; i ++) {
			struct Point nextPoint;
			nextPoint.x = curPoint.x + moves[i][0];
			nextPoint.y = curPoint.y + moves[i][1];
			nextPoint.z = curPoint.z + moves[i][2];

			if(nextPoint.x < 0 || nextPoint.x >= l || 
					nextPoint.y < 0 || nextPoint.y >= r ||
						nextPoint.z < 0 || nextPoint.z >= c) {
				continue;
			}

			if(dungeons[nextPoint.x][nextPoint.y][nextPoint.z] == '#') continue;

			walk[nextPoint.x][nextPoint.y][nextPoint.z] = walk[curPoint.x][curPoint.y][curPoint.z] + 1;

			if(dungeons[nextPoint.x][nextPoint.y][nextPoint.z] == 'E')
				return walk[nextPoint.x][nextPoint.y][nextPoint.z];

			dungeons[nextPoint.x][nextPoint.y][nextPoint.z] = '#';
			q.push(nextPoint);

		}
	}

	return -1;
}

int main() {

	while(scanf("%d %d %d", &l, &r, &c) != EOF) {

		int startPos[3] = {0};

		if(l == 0 || r == 0 || c == 0) break;

		for(int i = 0 ; i < l ; i ++) {
			for(int j = 0 ; j < r ; j ++) {
				scanf("%s", dungeons[i][j]);

				for(int k = 0 ; k < c ; k ++) {
					if(dungeons[i][j][k] == 'S') {
						startPos[0] = i;
						startPos[1] = j;
						startPos[2] = k;
					}
				}
			}
		}

		int result = BFS(startPos);

		if(result == -1) cout << "Trapped!" << endl;
		else cout << "Escaped in "<< result <<" minute(s)." << endl;

	}

	return 0;
}