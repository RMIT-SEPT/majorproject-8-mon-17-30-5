import React from 'react';
import CustomerPage from './CustomerPage';
import {cleanup} from '@testing-library/react';
import ShallowRenderer from 'react-test-renderer/shallow';

afterEach(cleanup);

it("render customerPage page correctly", () =>{
    const renderer = new ShallowRenderer();
    renderer.render(<CustomerPage/>);
    const result = renderer.getRenderOutput();
    expect(result.type).toBe('div');
    expect(result.props.children).toHaveLength(5);
});