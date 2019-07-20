# ajou-dirtycode
Dirty code for refactoring
# assignment-refactoring-sooyeon
##refactoring 과정
1.srp확인 > 문제없다고 판단.
2.updatequality함수에서 name을 비교하는 조건문들을 equals_name이라는 함수로 extract했음.
3.quality를 증가시키는 함수와 감소시키는 부분을 각각 quality_increase,quality_decrease함수로 extract했음.
4sellin을 감소시키는 부분을 sellin_decrease함수로 extract했음.
5.name이 "Sulfuras"와 같지 않은 경우 quality와 sellin이 감소하는데 sellin이 감소하는 부분이 다른 함수로 작성되어있으므로 
이를 지우고 name이 "Sulfuras"와 같을 때 qulity가 증가하는 부분에 sellin_decrease를 추가함.
6.quality<50 조건문이 반복되므로 이를 함수로 extract했음.
7.quality>0 조건문이 반복되므로 이를 함수로 extract했음.
8.sellin값을 비교하는 조건문이 여러개이므로 이를 함수로 extract했음.
9.quality가 50이하이며 name이 "Backstage~"인 경우 sellin 조건문들 안에 quality가50이하라는 조건문이 반복되므로 이를 지움.

