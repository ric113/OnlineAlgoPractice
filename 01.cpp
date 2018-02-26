#include <iostream>
#include <stdio.h>
#include <stdlib.h>
#include <vector>
#include <sstream>
#include <string>
#include <iterator>

using namespace std;

string toString(int i)
{
    std::stringstream ss;
    ss << i;
    return ss.str();
}

vector<string> SplitWithSpace(const string &source)
{
    stringstream ss(source);
    vector<string> vec( (istream_iterator<string>(ss)), istream_iterator<string>() );
    return vec;
}

bool isOperator(string s) {
	return (s == "+" || s == "-" || s == "*" || s == "/" || s == "%");
}

int cal(string op, int l, int r) {
	
	if (op == "+")
		return l + r;
	else if (op == "-")
		return l - r;
	else if (op == "*")
			return l * r;
	else if (op == "/")
			return l / r;
	else if (op == "%")
			return l % r;
	else 
		return -1;
	
}

int main() {

	string input;
	bool il = false;

	vector<string> ans;


 	while(getline(cin,input)){

 		if(input == ".") break;
		vector<std::string> result = SplitWithSpace(input);
		vector<string> stack;

		
		for(int i = result.size() -1 ; i >= 0 ; i --) {
			if(!isOperator(result[i])) {
				// cout << "number : " << result[i] << endl;
				stack.push_back(result[i]);
			}
			else {

				// cout << stack.back() << endl;
				if(stack.size() < 2) {
					il = true; break;
				}

				int l = atoi(stack.back().c_str());
				stack.pop_back();
				int r = atoi(stack.back().c_str());
				stack.pop_back();

				int res = cal(result[i], l , r);

				// cout << l << " " << result[i] << " " << r << " = " << res << endl;

				stack.push_back(toString(res));	

			}
		}

		if(stack.size() > 1) il = true;

		if(il) ans.push_back("illegal");
		else ans.push_back(stack.back());
		
	}

	for(int i = 0 ; i < ans.size() ; i ++)
		cout << ans[i] << endl;

	return 0;
}