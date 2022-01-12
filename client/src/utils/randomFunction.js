function getRandomComment(number) {

    const comments = [];
    for (let i = 0; i < number; i++) {
        console.log("comment")
        comments.push({
            id: Math.floor(Math.random() * 100000),
            name: 'Arthur',
            date: '6:40',
            message: '      Lorem ipsum dolor sit amet, consectetur adipisicing elit. Excepturi rem, voluptatem. Asperiores, distinctio, dolore esse fuga hic ipsa iusto libero molestiae quibusdam repellat sed totam? Dolores neque nisi ullam voluptas!\n',
        })
    }

    return comments
}

export {getRandomComment}