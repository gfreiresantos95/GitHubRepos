package br.com.githubrepos.dto


class MockedRepositoryData {

    fun getMockedData() = arrayListOf(
        RepositoryData(
            forks = 8611,
            id = 1,
            name = "test 1",
            owner = OwnerData(
                avatarUrl = "https://avatars.githubusercontent.com/u/82592?v=4",
                id = 6,
                login = "login 6"
            ),
            stargazersCount = 40629
        ),
        RepositoryData(
            forks = 10788,
            id = 2,
            name = "test 2",
            owner = OwnerData(
                avatarUrl = "https://avatars.githubusercontent.com/u/32689599?v=4",
                id = 7,
                login = "login 7"
            ),
            stargazersCount = 39278
        ),
        RepositoryData(
            forks = 4654,
            id = 3,
            name = "test 3",
            owner = OwnerData(
                avatarUrl = "https://avatars.githubusercontent.com/u/878437?v=4",
                id = 8,
                login = "login 8"
            ),
            stargazersCount = 38425
        ),
        RepositoryData(
            forks = 11479,
            id = 4,
            name = "test 4",
            owner = OwnerData(
                avatarUrl = "https://avatars.githubusercontent.com/u/3006190?v=4",
                id = 9,
                login = "login 9"
            ),
            stargazersCount = 31752
        ),
        RepositoryData(
            forks = 3798,
            id = 5,
            name = "test 5",
            owner = OwnerData(
                avatarUrl = "https://avatars.githubusercontent.com/u/82592?v=4",
                id = 0,
                login = "login 0"
            ),
            stargazersCount = 26542
        )
    )
}