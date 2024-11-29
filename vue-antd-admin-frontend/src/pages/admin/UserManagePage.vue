<template>
  <div id="userManagePage">
    <a-input-search
      v-model="searchValue"
      size="large"
      enter-button="搜索"
      placeholder="请输入用户名"
      style="max-width: 320px"
      @search="onSearch"
    />
    <a-table :columns="columns" :data-source="data">
      <template #bodyCell="{ column, record }">
        <template v-if="column.dataIndex === 'userRole'">
          <div v-if="record.userRole === 'admin'">
            <a-tag color="green">管理员</a-tag>
          </div>
          <div v-else>
            <a-tag color="blue">普通用户</a-tag>
          </div>
        </template>
        <template v-if="column.dataIndex === 'createTime'">
          {{ dayjs(record.createTime).format("YYYY-MM-DD HH:mm:ss") }}
        </template>
        <template v-if="column.key === 'action'">
          <a-button danger @click="doDelete(record.id)">删除</a-button>
        </template>
      </template>
    </a-table>
  </div>
</template>
<script lang="ts" setup>
import dayjs from "dayjs";
import { message } from "ant-design-vue";
import { ref } from "vue";
import { searchUsers, deleteUser } from "@/api/user";

const columns = [
  {
    title: "id",
    dataIndex: "id",
  },
  {
    title: "用户名",
    dataIndex: "nickname",
  },
  {
    title: "账号",
    dataIndex: "username",
  },
  {
    title: "头像",
    dataIndex: "avatarUrl",
  },
  {
    title: "性别",
    dataIndex: "gender",
  },
  {
    title: "创建时间",
    dataIndex: "createTime",
  },
  {
    title: "用户角色",
    dataIndex: "userRole",
  },
  {
    title: "Action",
    key: "action",
  },
];

const data = [
  {
    id: "1",
    nickname: "John Brown",
    username: "zkczdd",
    avatarUrl: "New York No. 1 Lake Park",
    gender: "男",
    createTime: "2022-01-01",
    userRole: "admin",
  },
  {
    id: "2",
    nickname: "Jim Green",
    username: "zkczdd1",
    avatarUrl: "New York No. 1 Lake Park",
    gender: "女",
    createTime: "2022-02-02",
    userRole: "admin",
  },
  {
    id: "3",
    nickname: "Joe Black",
    username: "zkczdd2",
    avatarUrl: "New York No. 1 Lake Park",
    gender: "男",
    createTime: "2022-03-03",
    userRole: "admin",
  },
  {
    id: "4",
    nickname: "Jim Red",
    username: "zkczdd3",
    avatarUrl: "New York No. 1 Lake Park",
    gender: "女",
    createTime: "2022-04-04",
    userRole: "user",
  },
];

const searchValue = ref("");
const onSearch = () => {
  // fetchData(searchValue.value);
  console.log(searchValue.value);
};
// 从后端获取数据
// // 用户数据
// const data = ref([]);
// // 获取数据
// const fetchData = async (username = "") => {
//   const res = await searchUsers(username);
// 	if (res.data.data) {
// 		data.value = res.data.data || [];
// 	} else {
// 		message.error("获取数据失败");
// 	}
// }
// fetchData()

//删除数据
const doDelete = async (id: string) => {
  if (!id) {
    return;
  }
  const res = await deleteUser(id);
  if (res.data.code === 0) {
    message.success("删除成功");
    // 刷新数据
    // fetchData(searchValue.value);
  } else {
    message.error("删除失败");
  }
};
</script>
