문제:

학교 관리를 위한 Java 클래스와 인터페이스를 디자인하고, 이를 활용하여 학교 구성원을 관리하고 반복(iterate)하는 기능을 구현하세요.

SchoolMember 인터페이스를 정의하세요.

SchoolMember 인터페이스는 다음과 같은 메서드를 가져야 합니다.
getName(): 학교 구성원의 이름을 반환하는 메서드.
Student 클래스를 생성하세요.

Student 클래스는 SchoolMember 인터페이스를 구현해야 합니다.
Student 클래스는 다음과 같은 필드를 가져야 합니다.
name: 학생의 이름을 나타내는 문자열 필드.
Student 클래스는 이름을 인자로 받아 초기화할 수 있는 생성자를 가져야 합니다.
School 클래스를 생성하세요.

School 클래스는 학교의 학생들을 관리하는데 사용됩니다.
addMember() 메서드를 사용하여 학교 구성원(학생)을 추가할 수 있어야 합니다.
School 클래스는 Iterable<SchoolMember> 인터페이스를 구현하여 SchoolMember 타입의 객체들을 반복할 수 있어야 합니다.

iterator() 메서드를 정의하여 반복 동작을 지원하세요.
마지막으로, SchoolIteratorExample 클래스를 만들어 다음 단계를 수행하세요.

School 객체를 생성하세요.
addMember() 메서드를 사용하여 여러 학생을 학교에 추가하세요.
for-each 루프를 사용하여 학교의 구성원들을 반복하고, 각 구성원의 이름을 출력하세요.
이 문제를 해결하기 위해 위에서 정의한 클래스와 인터페이스를 Java로 구현하세요. 이를 통해 객체 지향 프로그래밍, Iterator 및 Generic 인터페이스의 개념을 이해하고 활용할 수 있을 것입니다.