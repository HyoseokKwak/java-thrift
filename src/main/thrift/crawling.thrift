# This will set the generated java class
# in me.zhengdong.thrift package
namespace java com.test.khs

struct Item {
  1: i64 id,
  2: string content,
}

service CrawlingService {
    void write(1:list<Item> items),
}
